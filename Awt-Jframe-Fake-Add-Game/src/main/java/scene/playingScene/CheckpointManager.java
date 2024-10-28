package scene.playingScene;

import lombok.Setter;
import object.BaseClass;
import object.CheckpointRow;

import java.awt.*;
import java.util.ArrayList;

@Setter
public class CheckpointManager implements BaseClass {
    ArrayList<CheckpointRow> checkpointRows = new ArrayList<>();

    public CheckpointManager() {
    }



    public void update() {
        checkpointRows = new ArrayList<>(checkpointRows.stream().filter(e -> !e.isMarkedForDeletion()).toList());
        checkpointRows.forEach(CheckpointRow::update);
    }

    public void draw(final Graphics2D g) {
        for (final CheckpointRow checkpointRow : checkpointRows) {
            checkpointRow.draw(g);
        }
    }

}
