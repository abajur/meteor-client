/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package minegame159.meteorclient.mixininterface;

import net.minecraft.client.font.TextHandler;

public interface ITextHandler {
    TextHandler.WidthRetriever getWidthRetriever();
}
