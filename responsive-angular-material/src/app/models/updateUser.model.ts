export class UpdateUser {
    firstName: String;
    lastName: String;
    username: String;
    moderatorStatus: number;
    accessPermission: number;
    email: String;
    imageURL: String;

    constructor(firstName: String, lastName: String, username: String, moderatorStatus: number, accessPermission: number, email: String, imageURL: String){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.moderatorStatus = moderatorStatus;
        this.accessPermission = accessPermission;
        this.email = email;
        this.imageURL = imageURL;
    }
}