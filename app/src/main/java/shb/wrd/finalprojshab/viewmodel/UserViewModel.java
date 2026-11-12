package shb.wrd.finalprojshab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import shb.wrd.finalprojshab.model.MyUserTable.MyUser;
import shb.wrd.finalprojshab.repositories.UserRepository;

/**
 * نموذج عرض المستخدمين (UserViewModel) مسئول عن تجهيز وإدارة البيانات المتعلقة بالمستخدمين (MyUser) لصالح واجهات المستخدم (Views/Activities).
 * يقوم بالاحتفاظ بالبيانات وتجاوز عمليات إعادة إنشاء النشاط (Configuration Changes) مثل دوران الشاشة،
 * ويتعامل مع {@link UserRepository} لتنفيذ العمليات المختلفة.
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository repository;
    private final List<MyUser> allUsers;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة المستودع (UserRepository) وجلب قائمة جميع المستخدمين الأولية.
     *
     * @param application سياق التطبيق (Application Context) الممرر للـ AndroidViewModel.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAll();
    }

    /**
     * جلب جميع المستخدمين الموجودين في قاعدة البيانات.
     *
     * @return قائمة بجميع المستخدمين.
     */
    public List<MyUser> getAllUsers() {
        return allUsers;
    }

    /**
     * استخراج مستعمل حسب الأرقام المميزة له (userIds).
     *
     * @param userIds مصفوفة المعرفات الخاصة بالمستخدمين.
     * @return قائمة المستخدمين المطابقين للمعرفات.
     */
    public List<MyUser> loadAllByIds(int[] userIds) {
        return repository.loadAllByIds(userIds);
    }

    /**
     * فحص ما إذا كان المستخدم موجوداً بناءً على البريد الإلكتروني وكلمة السر.
     *
     * @param myEmail البريد الإلكتروني للمستخدم.
     * @param myPassw كلمة السر للمستخدم.
     * @return كائن المستخدم إذا وجد، أو null إذا لم يوجد.
     */
    public MyUser logIn(String myEmail, String myPassw) {
        return repository.checkEmailPassw(myEmail, myPassw);
    }

    /**
     * فحص ما إذا كان البريد الإلكتروني مستخدماً من قبل.
     *
     * @param myEmail البريد الإلكتروني المراد فحصه.
     * @return كائن المستخدم إذا كان البريد مسجلاً، أو null إذا لم يكن مسجلاً.
     */
    public MyUser checkEmail(String myEmail) {
        return repository.checkEmail(myEmail);
    }

    /**
     * إدراج مستخدم واحد في قاعدة البيانات.
     *
     * @param myUser كائن المستخدم المراد إضافته.
     */
    public void insert(MyUser myUser) {
        repository.insert(myUser);
    }

    /**
     * إدراج مستخدم واحد أو عدة مستخدمين في قاعدة البيانات.
     *
     * @param users المستخدمين المراد إضافتهم.
     */
    public void insertAll(MyUser... users) {
        repository.insertAll(users);
    }

    /**
     * تحديث مستخدم أو مجموعة مستخدمين في قاعدة البيانات.
     *
     * @param values المستخدمين المراد تحديث بياناتهم.
     */
    public void update(MyUser... values) {
        repository.update(values);
    }

    /**
     * حذف مستخدم محدد من قاعدة البيانات.
     *
     * @param user كائن المستخدم المراد حذفه.
     */
    public void delete(MyUser user) {
        repository.delete(user);
    }

    /**
     * حذف مستخدم حسب المعرف الفريد (ID).
     *
     * @param id المعرف الفريد للمستخدم المراد حذفه.
     */
    public void delete(int id) {
        repository.delete(id);
    }
}
