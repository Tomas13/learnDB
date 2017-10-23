/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package kazpost.kz.mobterminal.di.component;


import dagger.Component;
import kazpost.kz.mobterminal.di.PerActivity;
import kazpost.kz.mobterminal.di.module.ActivityModule;
import kazpost.kz.mobterminal.ui.closecell.CloseCellActivity;
import kazpost.kz.mobterminal.ui.dbcrud.CrudActivity;
import kazpost.kz.mobterminal.ui.dbcrud.CrudFragment;
import kazpost.kz.mobterminal.ui.main.MainActivity;
import kazpost.kz.mobterminal.ui.login.LoginActivity;
import kazpost.kz.mobterminal.ui.scanner.ScanActivity;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(CloseCellActivity activity);

    void inject(ScanActivity activity);

    void inject(CrudFragment fragment);
}
