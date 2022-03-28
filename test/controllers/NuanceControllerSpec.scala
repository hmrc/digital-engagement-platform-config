/*
 * Copyright 2022 HM Revenue & Customs
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

package controllers

import config.AppConfig
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.mvc.{AnyContentAsEmpty, Cookie, MessagesControllerComponents}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import views.html.NuanceFile

class NuanceControllerSpec
  extends AnyWordSpecLike
    with Matchers
    with GuiceOneAppPerSuite {

    implicit private val fakeRequest: FakeRequest[AnyContentAsEmpty.type] = FakeRequest("GET", "/").withCookies(Cookie("mdtp", "12345"))

    implicit val appConfig: AppConfig = app.injector.instanceOf[AppConfig]
    val messagesCC: MessagesControllerComponents = app.injector.instanceOf[MessagesControllerComponents]

    val nuanceFile: NuanceFile = app.injector.instanceOf[NuanceFile]

    private val controller = new NuanceController(
        appConfig,
        nuanceFile,
        messagesCC)

    def asDocument(html: String): Document = Jsoup.parse(html)

    "fixed URLs" should {
        "render nuance file page" in {
            val result = controller.nuance(fakeRequest)

            status(result) shouldBe OK
        }
    }
}
