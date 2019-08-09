export class User {
    firstName: String;
    lastName: String;
    username: String;
    pass: String;
    moderatorStatus: number;
    accessPermission: number;
    email: String;
    imageURL: String;

    constructor(firstName: String, lastName: String, username: String, pass: String, moderatorStatus: number, accessPermission: number, email: String, imageURL: String){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pass = pass;
        this.moderatorStatus = moderatorStatus;
        this.accessPermission = accessPermission;
        this.email = email;
        this.imageURL = imageURL;
    }
}