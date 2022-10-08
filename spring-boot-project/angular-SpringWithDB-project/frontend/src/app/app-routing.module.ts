import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { UpdatebookComponent } from "./updatebook/updatebook.component";

const routes : Routes = [
    {path: "updatebook/:id", component: UpdatebookComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }