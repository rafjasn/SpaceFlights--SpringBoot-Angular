import { TestBed } from '@angular/core/testing';

import { TouristDataService } from './tourist-data.service';

describe('TouristDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TouristDataService = TestBed.get(TouristDataService);
    expect(service).toBeTruthy();
  });
});
