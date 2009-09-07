/*
 * Copyright (c) 2009, Lombardi Software
 *  All rights reserved.
 *
 * Redistribution and use of this software in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above
 *   copyright notice, this list of conditions and the
 *   following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the
 *   following disclaimer in the documentation and/or other
 *   materials provided with the distribution.
 *
 * * Neither the name of Lombardi software nor the names of its
 *   contributors may be used to endorse or promote products
 *   derived from this software without specific prior
 *   written permission of Lombardi Software
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.atlassian.mike.plugins.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Example gadget using GWT.
 */
@Gadget.ModulePrefs(title = "Hello GWT Gadget", author = "Mike Cannon-Brookes", author_email = "mike@atlassian.com")
@Gadget.InjectModulePrefs(files = {"ModulePrefs.txt"})
@Gadget.InjectContent(files = {"ModuleContent.txt"})
public class HelloWorld extends Gadget<HelloPreferences> {
    int count = 0;
    private Label l;

    protected void init(HelloPreferences prefs) {
        count = Integer.parseInt(prefs.count().getValue());
        VerticalPanel p = new VerticalPanel();
        p.add(new Label("Vegie? " + prefs.noMeat().getValue()));
        l = new Label("Starting count: " + count);
        p.add(l);

        Button b = new Button("Add One");
        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                updateLabel();
            }
        });
        p.add(b);

        RootPanel.get().add(p);
    }

    private void updateLabel() {
        count++;

        l.setText("Count: " + count);
    }
}
