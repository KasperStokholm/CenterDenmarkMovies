import { Movie } from './movie.model';

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class MovieService {

  private backendUrl: string;

  constructor(private http: HttpClient){
    this.backendUrl = 'http://localhost:8080';
  }

  public getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.backendUrl + "/overview");
  }

  public createMovie(movie: Movie){
    return this.http.post<Movie>(this.backendUrl, movie);
  }

  getMovieById(id: number): Observable<Movie> {
    return this.http.get<Movie>(this.backendUrl);
  }


  /*
  private movies: Movie[] = [
    { id: 1, title: 'The Dark Knight', director: 'Christopher Nolan', year: 2008, rating: '10/10' },
    { id: 2, title: 'Godzilla Vs. Kong', director: 'Adam Wingard', year: 2021, rating: '5/10'},
    { id: 3, title: 'Star Wars Episode IV: A new hope', director: 'George Lucas', year: 1977, rating: '8/10' }
  ];

  constructor() { }

  getMovies(): Movie[] {
    return this.movies
  }

  getMovieById(id: number): Movie | undefined {
    return this.movies.find(movie => movie.id === id);
  }

  createMovie(movie: Movie): void {
    movie.id = this.generateRandomId();
    this.movies.push(movie);
  }

  private generateRandomId(): number {
    // Generate a random number between 1 and 1000
    return Math.floor(Math.random() * 1000) + 1;
  }*/

}
