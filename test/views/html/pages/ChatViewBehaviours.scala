/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package views.html.pages

import play.twirl.api.HtmlFormat

trait ChatViewBehaviours extends ViewSpecBase {

  def normalPage(view: () => HtmlFormat.Appendable,
                 nuancePreProdJavaScriptTag: String,
                 nuanceProdJavaScriptTag: String): Unit = {

    "behave like a normal page" when {
      "rendered" must {
        "have the correct nuancePreProdJavaScriptTag" in {
          val doc = asDocument(view())
          assertContainsText(doc, s"$nuancePreProdJavaScriptTag")
        }

        "have the correct Nuance nuanceProdJavaScriptTag" in {
          val doc = asDocument(view())
          assertContainsText(doc, s"$nuanceProdJavaScriptTag")
        }
      }
    }
  }
}