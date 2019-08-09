export class Post {

    id: number;
    username: String;
    content: String;
    channelName: String;
    commentID: number;
    likes: number;
    timeStamp: String;

    constructor(id:number, username: String, content: String, channelName: String, commentID: number,likes: number, timeStamp: String) {
            this.id = id;
            this.username = username;
            this.content = content;
            this.channelName = channelName;
            this.commentID = commentID;
            this.likes= likes;
            this.timeStamp = timeStamp;
    };
}