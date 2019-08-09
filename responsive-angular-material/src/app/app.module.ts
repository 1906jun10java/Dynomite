import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MyMaterialModule } from  './material/material.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MyComponentComponent } from './my-component/my-component.component';
import { RegistrationComponentComponent } from './registration-component/registration-component.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { RouterModule, Routes } from '@angular/router';
import { ProfileEditComponent } from './profile-edit/profile-edit.component';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { GlobalViewComponent } from './global-view/global-view.component';
import { ChannelListComponent } from './channel-list/channel-list.component';
import { ForumPostComponent } from './forum-post/forum-post.component';

@NgModule({
  declarations: [
    AppComponent,
    MyComponentComponent,
    RegistrationComponentComponent,
    LoginComponentComponent,
    ProfileComponent,
    ProfileEditComponent,
    GlobalViewComponent,
    ChannelListComponent,
    ForumPostComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    MyMaterialModule,
    RouterModule.forRoot([
      { path: '', redirectTo: '/', pathMatch: 'full' },
      { path: 'register', component: RegistrationComponentComponent },
      { path: 'login', component: LoginComponentComponent },
      { path: 'profile', component:ProfileComponent},
      { path: 'profile-edit', component:ProfileEditComponent},
      { path: 'globalview', component:GlobalViewComponent }
    ])],
       
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
