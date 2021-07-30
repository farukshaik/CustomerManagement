import {ViewChild,Component, OnInit, AfterViewInit} from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Observable } from 'rxjs';
import { DataSource } from '@angular/cdk/collections';
import {User} from '../../models/user.model';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort, Sort } from '@angular/material/sort';
import { AuthService } from 'src/app/auth.service';
import { viewClassName } from '@angular/compiler';
@Component({
  selector: 'usertable',
  templateUrl: './usertable.component.html',
  styleUrls: ['./usertable.component.css']
})
export class UserTableComponent implements OnInit,AfterViewInit {
  
  displayedColumns=['name','email','phone','company'];
  dataSource=new UserDataSource(this.userService);

  
  constructor(private userService: UserService,private authService: AuthService, private router: Router) { }

  ngOnInit() {}
  ngAfterViewInit(): void {

  }
  Back(){
    this.router.navigateByUrl('/admin');
  }
}
export class UserDataSource extends DataSource<any>{
  constructor(private userService: UserService){
    super();
  }
  connect(): Observable<User[]>{
    return this.userService.getUser();
  }
  disconnect(){}
}
