//import { TestBed } from '@angular/core/testing';
import {TestBed} from '@angular/core/testing';

import { APIServicesService } from './apiservices.service';

describe('APIServicesService', () => {
  let service: APIServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(APIServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
