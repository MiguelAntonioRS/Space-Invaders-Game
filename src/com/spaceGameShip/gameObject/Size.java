package com.spaceGameShip.gameObject;

import com.spaceGameShip.Graphics.Assets;
import java.awt.image.BufferedImage;

public enum Size {

    BIG(2, Assets.med),
    MED(2, Assets.small),
    SMALL(2, Assets.tinies),
    TINY(0, null);
    public int quantity;

    public BufferedImage[] textures;

    private Size(int quantity, BufferedImage[] textures) {
        this.quantity = quantity;
        this.textures = textures;
    }
}
