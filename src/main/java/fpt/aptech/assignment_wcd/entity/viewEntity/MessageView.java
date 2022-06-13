package fpt.aptech.assignment_wcd.entity.viewEntity;

import fpt.aptech.assignment_wcd.entity.myEnum.MessageType;

public class MessageView {
    private MessageType messageType;
    private String content;

    public MessageView() {
    }

    public MessageView(MessageType messageType, String content) {
        this.messageType = messageType;
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
