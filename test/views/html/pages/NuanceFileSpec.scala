/*
 * Copyright 2020 HM Revenue & Customs
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

import config.AppConfig
import play.api.mvc.Cookie
import play.api.test.FakeRequest
import play.twirl.api.HtmlFormat
import views.html.NuanceFile

class NuanceFileSpec extends ChatViewBehaviours {
  implicit override val fakeRequest = FakeRequest("GET", "/").withCookies(Cookie("mdtp", "12345"))

  val view = app.injector.instanceOf[NuanceFile]

  implicit val appConfig = app.injector.instanceOf[AppConfig]

  val preProdMode: String = System.getProperty("pre-prod.mode")

  def createView(preProdFlag: Boolean): () => HtmlFormat.Appendable = () => view(preProdFlag)(fakeRequest, messages)


  "Nuance File must display the correct tag in the view view when pre-prod.mode = false" must {
    val preProdFlag = appConfig.preProdMode.equals(true)
    behave like normalPage(
      createView(preProdFlag),
      "",
      "https://hmrc-uk.digital.nuance.com/chatskins/launch/inqChatLaunch10006719.js"
    )
  }

  "Nuance File must display the correct tag in the view view when pre-prod.mode = true" must {
    val preProdFlag = appConfig.preProdMode.equals(false)
    behave like normalPage(
      createView(preProdFlag),
      "https://hmrc-uk-preprod.digital.nuance.com/chatskins/launch/inqChatLaunch10006719.js",
      ""
    )
  }
}