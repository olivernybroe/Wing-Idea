package com.github.olivernybroe.wingidea.ide.highlighting

import com.github.olivernybroe.wingidea.WingBundle
import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.lang.WingLanguage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class WingColorSettingsPage: ColorSettingsPage {

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = WingLanguage.displayName

    override fun getIcon(): Icon = WingIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(WingLanguage, null, null)

    override fun getDemoText(): String = DEMO_TEXT

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = descriptors

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = additionalDescriptors

    companion object {
        private val descriptors = arrayOf(
            AttributesDescriptor(
                WingBundle.messagePointer("options.language.defaults.block.comment"),
                WingColors.BLOCK_COMMENT
            ),
            AttributesDescriptor(
                WingBundle.messagePointer("options.language.defaults.line.comment"),
                WingColors.LINE_COMMENT
            ),
            AttributesDescriptor(
                WingBundle.messagePointer("options.language.defaults.string"),
                WingColors.STRING_LITERAL
            ),

        )

        private val additionalDescriptors = emptyMap<String, TextAttributesKey>()

        private val DEMO_TEXT = """
        bring cloud;

        let bucket = new cloud.Bucket();
        let counter = new cloud.Counter(
          initial: 1
        );
        let queue = new cloud.Queue();

        queue.setConsumer(inflight (message: str) => {
          let index = counter.inc();
          bucket.put("wing-${'$'}{index}.txt", "Hello, ${'$'}{message}");
          log("file wing-${'$'}{index}.txt created");
        });
        """.trimIndent()
    }
}