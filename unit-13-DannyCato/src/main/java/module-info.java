module unit08 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;
    requires java.desktop;

    opens unit13.queens.view to javafx.fxml;
    exports unit13.queens.view;
    exports unit13.queens.model;
    exports unit13.backtracker;
}
