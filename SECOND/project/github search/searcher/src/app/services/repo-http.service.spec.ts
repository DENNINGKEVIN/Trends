import { TestBed } from '@angular/core/testing';

import { RepoHttpService } from './repo-http.service';

describe('RepoHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RepoHttpService = TestBed.get(RepoHttpService);
    expect(service).toBeTruthy();
  });
});
