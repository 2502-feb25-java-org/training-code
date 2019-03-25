import { Pipe, PipeTransform } from '@angular/core';
/*
Pipes are a way to write display value transformations 
that you can declare in your HTML

in order to create a pipe, we must create a class that 
implements the PipeTransform interface, and override the
transform() method of that interface 

the Pipe decorator is used for these classes, where we 
give the pipe the name by which we want its functionality
to be accessed in the template
ie {{ 100 | root }}
*/
@Pipe({
  name: 'sqroot'
})
export class SqrootPipe implements PipeTransform {

  transform(value: number): number {
    return Math.sqrt(value);
  }

}
