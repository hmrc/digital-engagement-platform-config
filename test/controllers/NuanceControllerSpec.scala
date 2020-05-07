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

package controllers

import config.AppConfig
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.scalatest.{Matchers, WordSpec}
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import play.api.mvc.{Cookie, MessagesControllerComponents}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class NuanceControllerSpec
  extends WordSpec
    with Matchers
    with GuiceOneAppPerSuite
    with ScalaCheckPropertyChecks {

    implicit private val fakeRequest = FakeRequest("GET", "/").withCookies(Cookie("mdtp", "12345"))

    val messagesCC = app.injector.instanceOf[MessagesControllerComponents]

    private val controller = new NuanceController(messagesCC)

    def asDocument(html: String): Document = Jsoup.parse(html)

    "fixed URLs" should {
        "render nuance production file page" in {
            val result = controller.nuanceProd(fakeRequest)

            status(result) shouldBe OK
        }

        "render nuance Pre Production file page" in {
            val result = controller.nuancePreProd(fakeRequest)

            status(result) shouldBe OK
        }
    }
}
