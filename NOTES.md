_Lab 5: Task 4: NOTES.md

1. My first build took about 3 minutes. The second build didn't even take a full minute.
2. The background color of my app changed. The app screen was black aside from the writing on the
   screen.
3. I just don't understand what a lot of the files do. I know that we talked about the fact that we
   won't even open most of the files but I would still like to understand what they are doing under
   the hood. I also don't fully understand how the emulator works, it's very interesting.

Week 5, Friday
Lab 6: Task 5: One question
I changed the padding number from 24 to 32. The contents of my app got moved further away from the
edge of the screen; there was more blank space around my photo and text.

Week 6, Wednesday
Lab 7: Task 5: 3 questions

1. Logcat
   FATAL EXCEPTION: main
   Process: edu.lemoyne.campusapp, PID: 27916
   java.lang.NoSuchMethodError: No virtual method removeLast()Ljava/lang/Object; in class
   Landroidx/compose/runtime/snapshots/SnapshotStateList; or its super classes (declaration of '
   androidx.compose.runtime.snapshots.SnapshotStateList' appears in /data/app/~~
   VcbyPQpjpPNMxRLIOnZ3og==/edu.lemoyne.campusapp-AN8-gDUlD1-pguF59e94YQ==/base.apk)
   at edu.lemoyne.campusapp.MainActivityKt.HomeScreen$lambda$19$lambda$16$lambda$15(MainActivity.kt:
    145)
   at edu.lemoyne.campusapp.MainActivityKt$$ExternalSyntheticLambda6.invoke(D8$$SyntheticClass:0)
   at androidx.compose.foundation.ClickableNode.onPointerEvent-H0pRuoY(Clickable.kt:935)
   at androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(HitPathTracker.kt:446)
   at androidx.compose.ui.input.pointer.Node.dispatchMainEventPass(HitPathTracker.kt:432)
   at androidx.compose.ui.input.pointer.NodeParent.dispatchMainEventPass(HitPathTracker.kt:285)
   at androidx.compose.ui.input.pointer.HitPathTracker.dispatchChanges(HitPathTracker.kt:181)
   at androidx.compose.ui.input.pointer.PointerInputEventProcessor.process-BIzXfog(
   PointerInputEventProcessor.kt:118)
   at androidx.compose.ui.platform.AndroidComposeView.sendMotionEvent-8iAsVTc(
   AndroidComposeView.andat androidx.compose.ui.platform.AndroidComposeView.handleMotionEvent-8iAsVTc(
   AndroidComposeView.android.kt:2629)
   at androidx.compose.ui.platform.AndroidComposeView.dispatchTouchEvent(
   AndroidComposeView.android.kt:2467)
   at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3121)
   at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2802)
   at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3121)
   at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2802)
   at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3121)
   at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2802)
   at android.view.ViewGroup.dispatchTransformedTouchEvent(ViewGroup.java:3121)
   at android.view.ViewGroup.dispatchTouchEvent(ViewGroup.java:2802)
   at com.android.internal.policy.DecorView.superDispatchTouchEvent(DecorView.java:500)
   at com.android.internal.policy.PhoneWindow.superDispatchTouchEvent(PhoneWindow.java:1912)
   at android.app.Activity.dispatchTouchEvent(Activity.java:4299)
   at com.android.internal.policy.DecorView.dispatchTouchEvent(DecorView.java:458)
   at android.view.View.dispatchPointerEvent(View.java:15309)
   at android.view.ViewRootImpl$ViewPostImeInputStage.processPointerEvent(ViewRootImpl.java:6778)
   at android.view.ViewRootImpl$ViewPostImeInputStage.onProcess(ViewRootImpl.java:6578)
   at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:6034)
   at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:6091)
   at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:6057)
   at android.view.ViewRootImpl$AsyncInputStage.forward(ViewRootImpl.java:6222)
   at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:6065)
   at android.view.ViewRootImpl$AsyncInputStage.apply(ViewRootImpl.java:6279)
   at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:6038)
   at android.view.ViewRootImpl$InputStage.onDeliverToNext(ViewRootImpl.java:6091)
   at android.view.ViewRootImpl$InputStage.forward(ViewRootImpl.java:6057)
   at android.view.ViewRootImpl$InputStage.apply(ViewRootImpl.java:6065)
   at android.view.ViewRootImpl$InputStage.deliver(ViewRootImpl.java:6038)
   at android.view.ViewRootImpl.deliverInputEvent(ViewRootImpl.java:9206)
   at android.view.ViewRootImpl.doProcessInputEvents(ViewRootImpl.java:9157)
   at android.view.ViewRootImpl.enqueueInputEvent(ViewRootImpl.java:9126)
   at android.view.ViewRootImpl$WindowInputEventReceiver.onInputEvent(ViewRootImpl.java:9329)
   at android.view.InputEventReceiver.dispatchInputEvent(InputEventReceiver.java:267)
   at android.os.MessageQueue.nativePollOnce(Native Method)
   at android.os.MessageQueue.next(MessageQueue.java:335)
2. We didn't account for a user pressing the add button with an empty text field, so our count
   increases even if a user tries to add an empty text field.
3. Remember keeps the same box every time the function runs. Without it, we would get a new box at
   zero every time.

Week 6, Friday
Lab 8: Task 1: A minimum Length
If this line went above the isEmpty() line, an empty input would automatically output "Too short -
at least 3 characters" instead of "Enter a name".

Lab 8: Task 2: A rule of my own
It doesn't make sense for a scrapbook page to be named only numbers. The title/name of the page
should be a short description of what the page will contain. I put this rule after checking if the
name was empty but before checking to make sure the name is within the character number
requirements. I think checking if the entire entered name is numbers is more important than checking
if the character requirement is met.

Lab 8: Task 3: Test your own app
| I typed | What the app did | Correct |
| --- | --- | --- |
| (nothing) | The "Add page" button is greyed out; I can't press it at all | yes |_
| 53 | "A name can't be only numbers" | yes |
| "hi" | "Too short - must be 3 characters" | yes |
| "Christmas Time 2025" | " 'Christmas Time 2025' is already on the list" | yes |
| "christmas time 2025" | " ' christmas time 2025' is already on the list" | yes |
| too long | The field cuts me off before I can type more than 40 characters | yes |
| "    " | THe "Add page" button is greyed out; I can't press it at all | yes |
