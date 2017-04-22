package mutitthreadingwithcolor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MutitthreadingWithColor extends Application {

    String[] colorArray = {"-fx-base: red;", "-fx-base: green;", "-fx-base: yellow;", "-fx-base: blue;",
        "-fx-base: red;", "-fx-base: orange;", "-fx-base: rgb(66, 244, 226);", "-fx-base: rgb(2, 244, 14);",
        "-fx-base: rgb(29, 30, 29);", "-fx-base: rgb(255, 2, 128);", "-fx-base: rgb(0, 212, 255);",
        "-fx-base: rgb(0, 255, 8)"};

    Thread colorBtnThread, colorBackgroundThread;
    TextArea textArea = new TextArea();
    TextArea textArea1 = new TextArea();

    BorderPane borderPane = new BorderPane();

    Stage window;

   public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        Button startBtn = new Button("Start MultiThread");
        textArea.setMaxWidth(350);
        textArea.setMaxHeight(250);

        textArea1.setMaxWidth(350);
        textArea1.setMaxHeight(250);

        startBtn.setOnAction(e -> {
            Thread1();
            Thread2();
        });

        borderPane.setLeft(textArea);
        borderPane.setCenter(startBtn);
        borderPane.setRight(textArea1);

        Scene scene = new Scene(borderPane, 900, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected void Thread1() {

        colorBtnThread = new Thread("color Btn Thread") {
            public void run() {
                for (String color : colorArray) {
                    textArea.setStyle(color);
                    textArea.setText("Hello this is Thread 1 :" + color);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        };
        colorBtnThread.start();
//        return colorBtn;
    }

    protected void Thread2() {

        colorBackgroundThread = new Thread("color background Thread") {
            public void run() {
                for (String color : colorArray) {
                    textArea1.setStyle(color);
                    try {
                        Thread.sleep(1700);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();

                    }
                }
            }

        };
        colorBackgroundThread.start();
    }

 
}
