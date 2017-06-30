enum Status {
    ONLINE, OFFLINE;
}

class ChatMessage {

    String id;

    String payload;

    public ChatMessage(String payload) {
        this.payload = payload;
    }


    public void sendMessageToChannel(Channel channel) {

    }

    public void sendMessageToDatabase() {

    }

    public void sendMessageOfflineServer() {

    }

}

class ChatUser {

    String Id;

    Map<ChatUser, Channel> map = new HashMap<>();

    Status status;

    public void updateStatus(Status status) {
        this.status = status;

    }

    public Status getStatus() {
        return status;
    }

    public void sendMesssage(String payload, ChatUser target) {


        ChatMessage message = new ChatMessage(payload);


        if (map.containsKey(target)) {
            Channel channel = map.get(target);
            if (target.getStatus() == Status.OFFLINE) {
                map.remove(target);

                message.sendMessageOfflineServer();
            } else {

                message.sendMessageToChannel(channel);
            }

        }


        message.sendMessageToDatabase();

    }


    public Channel applyChannel(ChatUser target) {


        if (map.containsKey(target)) {

            return map.get(target);
        } else {


            try {


                Channel channel = new Channel(this, target);
                map.put(target, channel);
                target.map.put(this, channel);

                return channel;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;


        }
    }
}


class Channel {

    String id;
    ChatUser ChatUserA;
    ChatUser ChatUserB;


    Map<ChatUser, ChatUser> map = new HashMap<>();


    public Channel(ChatUser ChatUserA, ChatUser ChatUserB) {

        this.ChatUserA = ChatUserA;
        this.ChatUserB = ChatUserB;
    }

    private void sendMessageToUser() {

    }


}
