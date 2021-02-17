/*
 * Copyright 2021 HM Revenue & Customs
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

import org.scalatest.{Matchers, WordSpec}
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.mvc.{AnyContentAsEmpty, Cookie}
import play.api.test.FakeRequest
import play.api.test.Helpers._

class NuanceControllerSpec
  extends WordSpec
    with Matchers
    with GuiceOneAppPerSuite {

    private val fakeRequest: FakeRequest[AnyContentAsEmpty.type] = FakeRequest("GET", "/").withCookies(Cookie("mdtp", "12345"))

    private val controller = app.injector.instanceOf[NuanceController]

    "fixed URLs" should {
        "render nuance file page" in {
            val result = controller.nuance(fakeRequest)

            status(result) shouldBe OK
        }
    }
}
