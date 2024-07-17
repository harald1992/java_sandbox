//package object.tile;
//
//import static helper.HelperFunctions.getRandomNumberBetween;
//import static helper.LoadSave.loadFullImage;
//
//public class Road extends Tile {
//
//    public Road(final int id, final int x, final int y) {
//        super(x, y);
//        setSprite(id);
//    }
//
//    private void setSprite(int index) {
//        final int randomTile = getRandomNumberBetween(0, 3);
//        if (randomTile == 0) {
//            this.sprite = loadFullImage("/sprites/road/tvlm041.png");
//        } else if (randomTile == 1) {
//            this.sprite = loadFullImage("/sprites/road/tvlm041mirrorhorizontal.png");
//        } else if (randomTile == 2) {
//        this.sprite = loadFullImage("/sprites/road/tvlm041mirrorvertical.png");
//    } else {
//            this.sprite = loadFullImage("/sprites/road/tvlm041mirrorhorizontalvertical.png");
//
//        }
////        tvlm041mirror this.sprite = loadFullImage("/sprites/road/tvlm041.png");
//
//        //        switch (index) {
//        //        case 0:
//        //            randomTileIndex = getRandomNumberBetween(21, 33);
//        //            this.sprite = loadFullImage("/sprites/water/water/watrtl" + randomTileIndex + ".png");
//        //            break;
//        //
//        //        case 1:
//        //            // water-top
//        //            this.sprite = loadFullImage("/sprites/water/water/watrtl" + randomTileIndex + ".png");
//        //            break;
//        //
//        //        case 2: // water-right
//        //            randomTileIndex = getRandomNumberBetween(5, 8);
//        //            this.sprite = loadFullImage("/sprites/water/water-right/watrtl0" + randomTileIndex + ".png");
//        //            break;
//        //
//        //        case 3: // water-bottom
//        //            this.sprite = loadFullImage("/sprites/water/water/watrtl" + randomTileIndex + ".png");
//        //            break;
//        //
//        //        case 4: // water-left
//        //            randomTileIndex = getRandomNumberBetween(5, 8);
//        //
//        //            this.sprite = loadFullImage("/sprites/water/water-left/watrtl0" + randomTileIndex + "mirror.png");
//        //            break;
//        //        }
//
//    }
//}
