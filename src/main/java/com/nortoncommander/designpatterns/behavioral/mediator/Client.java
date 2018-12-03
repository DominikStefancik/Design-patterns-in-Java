package com.nortoncommander.designpatterns.behavioral.mediator;

import com.nortoncommander.designpatterns.behavioral.mediator.impl.Label;
import com.nortoncommander.designpatterns.behavioral.mediator.impl.Slider;
import com.nortoncommander.designpatterns.behavioral.mediator.impl.TextBox;
import com.nortoncommander.designpatterns.behavioral.mediator.impl.UIMediator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Client extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    UIMediator mediator = new UIMediator();
    Slider slider = new Slider(mediator);
    TextBox textBox = new TextBox(mediator);
    Label label = new Label(mediator);

    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setVgap(20);
    gridPane.setPadding(new Insets(25, 25, 25, 25));
    gridPane.add(label, 0, 0);
    gridPane.add(slider, 0, 1);
    gridPane.add(textBox, 0, 2);
    Scene scene = new Scene(gridPane, 500, 500);
    stage.setTitle("Mediator Pattern");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
