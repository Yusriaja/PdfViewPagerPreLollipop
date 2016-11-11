/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.pdfviewpager.library.adapter;

import android.graphics.Bitmap;


public class PdfRendererParams {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;

    int width;
    int height;
    float renderQuality;
    int offScreenSize;
    Bitmap.Config config = DEFAULT_CONFIG;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getRenderQuality() {
        return renderQuality;
    }

    public void setRenderQuality(float renderQuality) {
        this.renderQuality = renderQuality;
    }

    public int getOffScreenSize() {
        return offScreenSize;
    }

    public void setOffScreenSize(int offScreenSize) {
        this.offScreenSize = offScreenSize;
    }

    public Bitmap.Config getConfig() {
        return config;
    }

    public void setConfig(Bitmap.Config config) {
        this.config = config;
    }

    public void setDimensions(int width, int height, float renderQuality) {
        // @ToDo: re-examine the validity of these assumptions; determine REAL max bitmap size, consider orientation of tablet different from book
        this.renderQuality = 1;

        if (height > width) {
            double aspectRatio = (double)width / (double)height;
            this.height = 2048;
            this.width = (int)(width * aspectRatio);
        }
        else {
            double aspectRatio = (double)height / (double)width;
            this.width = 2048;
            this.height = (int)(height * aspectRatio);
        }
    }
}
