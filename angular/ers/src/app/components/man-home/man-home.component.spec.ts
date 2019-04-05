import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManHomeComponent } from './man-home.component';

describe('ManHomeComponent', () => {
  let component: ManHomeComponent;
  let fixture: ComponentFixture<ManHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
