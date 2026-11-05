package shb.wrd.finalprojshab.repositories;

import android.app.Application;

import java.util.List;

import shb.wrd.finalprojshab.model.AppDataBase;
import shb.wrd.finalprojshab.model.MyUserTable.MyUser;
import shb.wrd.finalprojshab.model.MyUserTable.MyUserQuery;

/**
 * مستودع المستخدمين (MyUser) يعمل كطبقة وسيطة ومنظمة للوصول إلى بيانات المستخدمين (UserRepository).
 * يقوم بفصل قاعدة بيانات
 * Room و {@link MyUserQuery}
 * عن بقية أجزاء التطبيق (ViewModels).
 */
public class UserRepository {
    private MyUserQuery userQuery; // واجهة الاستعلامات
    private List<MyUser> allUsers; // مبنى معطيات يحوي جميع المستخدمين المستخرجين

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائن الـ DAO الخاص بالمستخدمين.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public UserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        userQuery = db.getMyUserQuery();
        allUsers = userQuery.getAll();
    }

    /**
     * جلب جميع المستخدمين الموجودين في قاعدة البيانات.
     *
     * @return قائمة بجميع المستخدمين.
     */
    public List<MyUser> getAll() {
        return allUsers;
    }

    /**
     * استخراج مستعمل حسب الأرقام المميزة له (userIds).
     *
     * @param userIds مصفوفة المعرفات الخاصة بالمستخدمين.
     * @return قائمة المستخدمين المطابقين للمعرفات.
     */
    public List<MyUser> loadAllByIds(int[] userIds) {
        return userQuery.loadAllByIds(userIds);
    }

    /**
     * فحص ما إذا كان المستخدم موجوداً بناءً على البريد الإلكتروني وكلمة السر.
     *
     * @param myEmail البريد الإلكتروني للمستخدم.
     * @param myPassw كلمة السر للمستخدم.
     * @return كائن المستخدم إذا وجد، أو null إذا لم يوجد.
     */
    public MyUser checkEmailPassw(String myEmail, String myPassw) {
        return userQuery.checkEmailPassw(myEmail, myPassw);
    }

    /**
     * فحص ما إذا كان البريد الإلكتروني مستخدماً من قبل.
     *
     * @param myEmail البريد الإلكتروني المراد فحصه.
     * @return كائن المستخدم إذا كان البريد مسجلاً، أو null إذا لم يكن مسجلاً.
     */
    public MyUser checkEmail(String myEmail) {
        return userQuery.checkEmail(myEmail);
    }

    /**
     * إدراج مستخدم واحد أو عدة مستخدمين في قاعدة البيانات.
     *
     * @param users المستخدمين المراد إضافتهم.
     */
    public void insertAll(MyUser... users) {
        userQuery.insertAll(users);
    }

    /**
     * إدراج مستخدم واحد في قاعدة البيانات.
     *
     * @param myUser كائن المستخدم المراد إضافته.
     */
    public void insert(MyUser myUser) {
        userQuery.insert(myUser);
    }

    /**
     * تحديث مستخدم أو مجموعة مستخدمين في قاعدة البيانات.
     *
     * @param values المستخدمين المراد تحديث بياناتهم.
     */
    public void update(MyUser... values) {
        userQuery.update(values);
    }

    /**
     * حذف مستخدم محدد من قاعدة البيانات.
     *
     * @param user كائن المستخدم المراد حذفه.
     */
    public void delete(MyUser user) {
        userQuery.delete(user);
    }

    /**
     * حذف مستخدم حسب المعرف الفريد (ID).
     *
     * @param id المعرف الفريد للمستخدم المراد حذفه.
     */
    public void delete(int id) {
        userQuery.delete(id);
    }
}
