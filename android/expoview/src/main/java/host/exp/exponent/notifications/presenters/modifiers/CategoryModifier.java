package host.exp.exponent.notifications.presenters.modifiers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import host.exp.exponent.kernel.KernelConstants;
import host.exp.exponent.notifications.IntentProvider;
import host.exp.exponent.notifications.NotificationActionCenter;

public class CategoryModifier implements NotificationModifierInterface {
  @Override
  public void modify(NotificationCompat.Builder builder, Bundle notification, Context context, String experienceId) {
    NotificationActionCenter.setCategory((String) notification.get("categoryId"), builder, context, new IntentProvider() {
      @Override
      public Intent provide() {
        Class activityClass = KernelConstants.MAIN_ACTIVITY_CLASS;
        Intent intent = new Intent(context, activityClass);
        intent.putExtra(KernelConstants.NOTIFICATION_OBJECT_KEY, notification.toString());
        return intent;
      }
    });
  }
}