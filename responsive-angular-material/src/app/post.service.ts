import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { post } from 'selenium-webdriver/http';
import { Post } from './models/post.model';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private getPosts: string="http://ec2-54-196-29-226.compute-1.amazonaws.com:8082/FacelessBook-0.0.1-SNAPSHOT/posts";

  constructor(private http: HttpClient) { }

  public createPost(post){
    return this.http.post<any>(this.getPosts + "/insert", post);
  }

  public getPostsMethod(){
    return this.http.get<Post[]>(this.getPosts);
  }
}
