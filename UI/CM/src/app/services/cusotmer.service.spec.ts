import { TestBed } from '@angular/core/testing';

import { CusotmerService } from './cusotmer.service';

describe('CusotmerService', () => {
  let service: CusotmerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CusotmerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
