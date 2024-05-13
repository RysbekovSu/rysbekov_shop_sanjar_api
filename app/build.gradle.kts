plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.rysbekov_shop_api"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rysbekov_shop_api"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
//JsonConverter
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.google.code.gson:gson:2.8.6")
    //расширение возможностей фрагмента:implementation ("androidx.fragment:fragment:1.6.2")
//Glide передача  картинки и работа с ней:
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
// круглое изображение
    implementation ("de.hdodenhof:circleimageview:3.1.0")
//Возможность преобразовать объект в необходимый формат:implementation ("androidx.multidex:multidex:2.0.1")
//Animation
    implementation ("com.airbnb.android:lottie:3.6.1")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$2.7.0")
// LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$2.7.0")
}
