package com.dagger2demo

class Document {
    /*
    1) @Component (provision method) and @Inject
    2) Field Injection -> we need to create inject method with activity reference. where we use the field injection-> where we have not any constructor of the class like framework (MainActivity )
    3)Method injection
    4) @Module and @Provider methods
    5) @Binds and @Providers
    6) providing value at the run time
    7) @Component builder , @Bindsinstance and @named
     */




    /*
    Field Injection

When we are working with an android framework like activity (i.e we are not able to create the constructor of activity , this is handled by android framework )/OS then we should go for field injection .

Class MainActivity {

@Inject
lateinit val mobile :Mobile   // Field injection


}

     */
}