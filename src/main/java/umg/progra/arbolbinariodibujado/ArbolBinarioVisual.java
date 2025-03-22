package umg.progra.arbolbinariodibujado;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import umg.progra.arbolbinariodibujado.Arbol;
import umg.progra.arbolbinariodibujado.Nodo;

public class ArbolBinarioVisual extends Application {
    private Arbol arbol = new Arbol();
    private Pane pane = new Pane();

    @Override
    public void start(Stage primaryStage) {
        // Insertar nodos en el árbol
        int[] valores = {20, 10, 30, 5, 25, 15, 35, 1, 6, 11, 16, 21, 26, 31, 36};
        for (int valor : valores) {
            arbol.insertar(valor);
        }

        dibujarArbol();

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Árbol Binario de Búsqueda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void dibujarArbol() {
        pane.getChildren().clear();
        dibujarNodo(pane, arbol.obtenerRaiz(), 400, 50, 150);
    }

    private void dibujarNodo(Pane pane, Nodo nodo, double x, double y, double offset) {
        if (nodo != null) {
            if (nodo.GetSubarbolIzdo() != null) {
                double xIzq = x - offset;
                double yIzq = y + 50;
                Line lineaIzq = new Line(x, y, xIzq, yIzq);
                pane.getChildren().add(lineaIzq);
                dibujarNodo(pane, nodo.GetSubarbolIzdo(), xIzq, yIzq, offset / 1.5);
            }
            if (nodo.GetSubarbolDcho() != null) {
                double xDer = x + offset;
                double yDer = y + 50;
                Line lineaDer = new Line(x, y, xDer, yDer);
                pane.getChildren().add(lineaDer);
                dibujarNodo(pane, nodo.GetSubarbolDcho(), xDer, yDer, offset / 1.5);
            }

            Circle circle = new Circle(x, y, 15);
            circle.setFill(Color.LIGHTBLUE);
            circle.setStroke(Color.BLACK);
            Text text = new Text(x - 5, y + 5, String.valueOf(nodo.valorNodo()));
            pane.getChildren().addAll(circle, text);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

