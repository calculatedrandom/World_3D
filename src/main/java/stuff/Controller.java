package stuff;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Controller {

    @FXML
    Canvas can;
    @FXML
    AnchorPane ap1;

    @FXML
    private void initialize() {
        ap1.layoutBoundsProperty().addListener(observable -> {
            can.setWidth(ap1.getWidth());
            can.setHeight(ap1.getHeight());

            can.getGraphicsContext2D().clearRect(0, 0, can.getWidth(), can.getHeight());
            can.getGraphicsContext2D().strokeLine(0, 0, can.getWidth(), can.getHeight());
        });

        Platform.runLater(() -> {
            ap1.getScene().getWindow().setHeight(ap1.getHeight());
        });


        MePoints points = new MePoints();
        points.p1x = 100;
        points.p1y = 100;
        points.p2x = 100;
        points.p2y = 200;

        final double[] startX = new double[1];
        final double[] startY = new double[1];

        double originX = 300;
        double originY = 250;

        can.setOnMousePressed(event -> {
            startX[0] = event.getX();
            startY[0] = event.getY();
        });

        can.setOnMouseDragged(event -> {
            double moveX = event.getX() - startX[0];
            double moveY = event.getY() - startY[0];
            points.move(moveX, moveY);

            can.getGraphicsContext2D().clearRect(0, 0, can.getWidth(), can.getHeight());
            can.getGraphicsContext2D().strokeLine(points.p1x, points.p1y, points.p2x, points.p2y);


            can.getGraphicsContext2D().strokeLine(points.p1x, points.p1y, originX, originY);
            can.getGraphicsContext2D().strokeLine(points.p2x, points.p2y, originX, originY);


            can.getGraphicsContext2D().fillText(String.valueOf(points.p1x), 100, 100);

            startX[0] = event.getX();
            startY[0] = event.getY();
        });

        System.out.println(System.getenv("APPDATA"));
        System.out.println(System.getenv("LOCALAPPDATA"));
    }

}

class MePoints {
    int p1x, p1y;
    int p2x, p2y;

    public void move(double x, double y) {
        p1x += x;
        p2x += x;
        p1y += y;
        p2y += y;
    }
}