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
import views.html.NuanceFile

class NuanceFileSpec extends ChatViewBehaviours {
  private val view = app.injector.instanceOf[NuanceFile]

  private def createView(preProdFlag: Boolean): () => HtmlFormat.Appendable =
    () => view(preProdFlag)


  "Nuance File must display the correct tag in the view when pre-prod.mode = false" must {
    behave like normalPage(
      createView(false),
      "",
      "https://hmrc-uk.digital.nuance.com/chatskins/launch/inqChatLaunch10006719.js"
    )
  }

  "Nuance File must display the correct tag in the view when pre-prod.mode = true" must {
    behave like normalPage(
      createView(true),
      "https://hmrc-uk-preprod.lle.digital.nuance.com/chatskins/launch/inqChatLaunch10006719.js",
      ""
    )
  }
}