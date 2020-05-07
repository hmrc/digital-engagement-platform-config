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

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.play.bootstrap.controller.FrontendController
import views.html.NuanceFileProd
import views.html.NuanceFilePreProd

import scala.concurrent.Future

@Singleton
class NuanceController @Inject()(mcc: MessagesControllerComponents) extends FrontendController(mcc) {

  def nuanceProd: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(NuanceFileProd()))
  }

  def nuancePreProd: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(NuanceFilePreProd()))
  }
}
