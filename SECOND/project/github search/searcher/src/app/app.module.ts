import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GithubComponent } from './github/github.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { RepositoryDetailsComponent } from './repository-details/repository-details.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TimeCountPipe } from './time-count.pipe';
import { HighlightDirective } from './highlight.directive';
import { SearchFormComponent } from './search-form/search-form.component';

@NgModule({
  declarations: [
    AppComponent,
    GithubComponent,
    HomeComponent,
    NavbarComponent,
    NotFoundComponent,
    RepositoryDetailsComponent,
    UserDetailsComponent,
    TimeCountPipe,
    HighlightDirective,
    SearchFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
