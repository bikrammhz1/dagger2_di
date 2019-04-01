# Dagger

Dagger is a fully static, compile-time dependency injection framework for both Java and Android.
It is an adaptation of an earlier version created by Square and now maintained by Google.

## Dagger 2 uses the following annotations:

@Module and @Provides: define classes and methods which provide dependencies

@Inject: request dependencies. Can be used on a constructor, a field, or a method

@Component: enable selected modules and used for performing dependency injection

Dagger 2 uses generated code to access the fields and not reflection. Therefore it is not allowed to use
private fields for field injection.




