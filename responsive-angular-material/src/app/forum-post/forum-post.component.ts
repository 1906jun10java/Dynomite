import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Post } from '../models/post.model';
import { User } from '../models/user.model';
import { Route, Router } from '@angular/router';
import { PostService } from '../post.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-forum-post',
  templateUrl: './forum-post.component.html',
  styleUrls: ['./forum-post.component.css']
})
export class ForumPostComponent implements OnInit {

  private getPosts: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/posts";
  private insertPostUrl: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/posts/insert";

  private listOfUsers: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/users";
  private banUrl: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/users/ban"
  posts: Post[];
  user: User = JSON.parse(window.localStorage.getItem('loggedUser'));

  post: Post = {
    id: null,
    username: this.user.username,
    content:"",
    channelName:"Global",
    commentID:0,
    likes:0,
    timeStamp:null
  };

  constructor(private http: HttpClient, private _router: Router, private postService: PostService) { }

  // createPost(){
  //   console.log(this.post);
  //   return this.http.post<any>(this.postService.createPost + "/insert", this.post);
  // }

  ngOnInit() {
    this.http.get(this.getPosts)
    .subscribe(
      (response: Post[]) => {
        this.posts = response;
      }
    );
    //  = this.postService.getPostsMethod();
    // console.log(this.posts);
  }

  createPost(){
    console.log(this.post);
    this.http.post<any>(this.insertPostUrl, this.post)
    .subscribe(
      resp => {
        console.log("Created new post");
        location.reload();
      },
      err => {
        console.log("Error adding the new post");
        location.reload();
      }
    );
  }

  deletePost(id){
    console.log(id);
    this.http.post<any>(this.getPosts + "/delete", id)
    .subscribe(
      resp => {
        console.log("Deleted the post");
        location.reload();
      },
      err => {
        console.log("Error in deleting post");
        location.reload();
      }
    );
  }

  banUser(u){
    console.log("You have chosen to ban " + u);
    this.http.post<any>(this.banUrl, u)
    .subscribe(
      resp => {
        console.log("Banned " + u);
        location.reload();
      },
      err => {
        console.log("Failed to ban " + u);
        location.reload();
      }
    );
  }

}
