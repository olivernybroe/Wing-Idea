package com.github.olivernybroe.wingidea.ide

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.javascript.nodejs.interpreter.NodeJsInterpreterManager
import com.intellij.javascript.nodejs.interpreter.local.NodeJsLocalInterpreter
import com.intellij.javascript.nodejs.interpreter.wsl.WslNodeInterpreter
import com.intellij.javascript.nodejs.npm.NpmManager
import com.intellij.openapi.project.Project


/**
 * Defines small wrapper functions around GeneralCommandLine to run wing commands.
 *
 * @see [GeneralCommandLine]
 */
class WingCommandLine {

    companion object {
        fun createCommand(project: Project, vararg commands: String): GeneralCommandLine {
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

        fun createLsp(project: Project): GeneralCommandLine = createCommand(project, "lsp")
        fun createConsole(project: Project): GeneralCommandLine = createCommand(project, "it", "--no-open")
    }
}