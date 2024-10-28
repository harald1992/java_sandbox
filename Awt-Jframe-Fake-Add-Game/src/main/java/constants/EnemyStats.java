package constants;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EnemyStats {

    private int width;
    private int height;
    private ArrayList<BufferedImage> sprites;
    private boolean shooter;
    private float attackRange;
}
