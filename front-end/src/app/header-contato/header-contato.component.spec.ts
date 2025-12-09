import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderContatoComponent } from './header-contato.component';

describe('HeaderContatoComponent', () => {
  let component: HeaderContatoComponent;
  let fixture: ComponentFixture<HeaderContatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HeaderContatoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderContatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
