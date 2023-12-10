import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UI {
    private static VBox chatArea;
    public static VBox CreateUI() {
        VBox appUI = new VBox(CreateTitleBar(), CreateChatArea(), CreateInputBar());
        return appUI;
    }
    public static VBox CreateTitleBar() {
        ImageView titleBarImage = new ImageView("resource/titleBar.png");
        titleBarImage.setFitHeight(89);
        titleBarImage.setFitWidth(375);
        titleBarImage.getStyleClass().add("titleBarImage");
        VBox titleBar = new VBox(titleBarImage);
        titleBar.getStyleClass().add("titleBar");
        return titleBar;
    }

    public static VBox CreateChatArea() {
        chatArea = new VBox(5);
        chatArea.getStyleClass().add("chatArea");
        return chatArea;
    }

    public static HBox CreateInputBar() {
        TextField textInputArea = new TextField();
        textInputArea.setPromptText("message...");
        textInputArea.getStyleClass().add("textInputArea");
        Button mediaButton = new Button("", CreateIcon("resource/media.png", 22));
        mediaButton.getStyleClass().add("mediaButton");
        Button sendButton = new Button("", CreateIcon("resource/send.png", 22));
        sendButton.getStyleClass().add("sendButton");
        sendButton.setOnAction((e) -> {
            String message = textInputArea.getText();
            if (!message.isEmpty()) {
                Label messageBox = new Label(message);
                messageBox.getStyleClass().add("messageBox");
                chatArea.getChildren().add(messageBox);
                textInputArea.clear();
            }
        });

        HBox inputBar = new HBox(10, mediaButton, textInputArea, sendButton);
        inputBar.getStyleClass().add("inputBar");
        inputBar.setAlignment(Pos.CENTER);
        return inputBar;
    }
    public static ImageView CreateIcon (String url, int size) {
        Image img = new Image(url);
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(size);
        imgView.setPreserveRatio(true);
        return imgView;
    }
}