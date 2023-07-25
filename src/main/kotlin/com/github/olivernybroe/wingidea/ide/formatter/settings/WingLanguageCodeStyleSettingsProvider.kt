package com.github.olivernybroe.wingidea.ide.formatter.settings

import com.github.olivernybroe.wingidea.lang.WingLanguage
import com.intellij.lang.Language
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider

class WingLanguageCodeStyleSettingsProvider: LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language = WingLanguage

    override fun getCodeSample(settingsType: SettingsType): String {
        return """
            bring cloud;
            bring util;

            class Foo  {
              field1: str;     // <-- readonly
              var field2: num; // <-- reassignable
              inflight field3: Array<str>;

              init() {
                this.field1 = "hello";
                this.field2 = 123;
              }

              setField2(value: num): void {
                this.field2 = value;
              }

              inflight init() {
                this.field3 = ["value created on inflight init"];
                log("at inflight init");
              }

              inflight doStuff() {
                // all code is async and runs on the cloud
                log("field3[0]='${"$"}{this.field3.at(0)}'");
                util.sleep(1s);
                log("done");
              }
            }

            let f = new Foo();
            log("field1=${"$"}{f.field1}");
            log("field2=${"$"}{f.field2}");

            new cloud.Function(inflight () => {
              f.doStuff();
            });

        """.trimIndent()
    }
}