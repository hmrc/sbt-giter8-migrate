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

package uk.gov.hmrc

import giter8.ScaffoldPlugin
import giter8.ScaffoldPlugin.autoImport.g8Scaffold
import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin

object Giter8migratePlugin extends AutoPlugin {

  // Determines when the plugin is enable. When all requirement plugins are available.
  override def trigger = allRequirements
  // required plugins for this plugin to work.
  override def requires = ScaffoldPlugin

  // Contents of this are auto-imported when sbt-giter8-migrate plugin is enabled. (Into the users build.sbt).
  object autoImport {}

  import scala.sys.process._

  override lazy val projectSettings = Seq(
    g8Scaffold := {
      g8Scaffold.evaluated
      val scriptFile = baseDirectory.value / "migrate.sh"
      s"sh $scriptFile".!
    }
  )
}
