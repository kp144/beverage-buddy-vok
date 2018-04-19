/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.starter.beveragebuddy.ui

import com.github.vok.karibudsl.flow.content
import com.github.vok.karibudsl.flow.div
import com.github.vok.karibudsl.flow.h2
import com.github.vok.karibudsl.flow.routerLink
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.icon.VaadinIcons
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.page.BodySize
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.HighlightConditions
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.server.InitialPageSettings
import com.vaadin.flow.server.PageConfigurator
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

/**
 * The main layout contains the header with the navigation buttons, and the
 * child views below that.
 */
@BodySize(width = "100vw", height = "100vh")
@HtmlImport("frontend://styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(Lumo::class)
class MainLayout : VerticalLayout(), RouterLayout, PageConfigurator {

    init {
        addClassName("main-layout")
        content { align(stretch, top) }
        div { // header // can we have the header as a sidebar in the application
            addClassName("main-layout__header")
            h2("Beverage Buddy") {
                addClassName("main-layout__title")
            }
            div { // navigation
                addClassName("main-layout__nav")
                routerLink(VaadinIcons.LIST, "Reviews", ReviewsList::class.java) {
                    addClassName("main-layout__nav-item")
                    highlightCondition = HighlightConditions.sameLocation()
                }
                routerLink(VaadinIcons.ARCHIVES, "Categories", CategoriesList::class.java) {
                    addClassName("main-layout__nav-item")
                    highlightCondition = HighlightConditions.sameLocation()
                }
            }
        }
    }

    override fun configurePage(settings: InitialPageSettings) {
        settings.addMetaTag("apple-mobile-web-app-capable", "yes")
        settings.addMetaTag("apple-mobile-web-app-status-bar-style", "black")
    }

    companion object {
        private val ACTIVE_ITEM_STYLE = "main-layout__nav-item--selected"
    }
}
