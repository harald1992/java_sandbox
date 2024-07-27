package manager;

import lombok.Setter;
import object.BaseClass;
import object.CheckpointRow;

import java.awt.*;
import java.util.ArrayList;

@Setter
public class CheckpointManager implements BaseClass {

    private final LevelManager levelManager;

    ArrayList<CheckpointRow> checkpointRows;

    public CheckpointManager(final LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void update() {
        checkpointRows = new ArrayList<>(checkpointRows.stream().filter(e -> !e.isMarkedForDeletion()).toList());
        checkpointRows.forEach(CheckpointRow::update);
    }

    public void draw(Graphics2D g) {
        for (final CheckpointRow checkpointRow : checkpointRows) {
            checkpointRow.draw(g);
        }
    }

}
