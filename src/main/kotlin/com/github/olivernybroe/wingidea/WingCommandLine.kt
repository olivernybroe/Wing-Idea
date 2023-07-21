package com.github.olivernybroe.wingidea

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.interpreter.wsl.WslNodeInterpreter
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.openapi.project.Project

class WingCommandLine(val project: Project, val command: String) {

    companion object {
        fun CreateCommand(project: Project, vararg commands: String): GeneralCommandLine {
            val interpreter = NodeJsInterpreterManager.getInstance(project).interpreter
            if (interpreter !is NodeJsLocalInterpreter && interpreter !is WslNodeInterpreter) {
                // shouldn't happen, checked in PrismaLspServerSupportProvider
                throw ExecutionException("Not configured")
            }

            val npmPath = NpmManager.getInstance(project).getPackage(interpreter)!!.systemDependentPath

            return GeneralCommandLine().apply {
                withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
                withCharset(Charsets.UTF_8)
                withWorkDirectory(project.basePath)
                withExePath(npmPath.replaceAfterLast("/", "npx").replaceAfterLast("\\", "npx.cmd"))
                addParameter("wing")
                addParameters(*commands)
            }
        }

        fun CreateLsp(project: Project): GeneralCommandLine = CreateCommand(project, "lsp")
        fun CreateConsole(project: Project): GeneralCommandLine = CreateCommand(project, "it", "--no-open")
    }
}