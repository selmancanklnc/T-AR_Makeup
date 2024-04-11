ARCore Try-on Makeup


```
<fragment android:name="blog.creativetech.arfaces.arface.AugmentedFaceFragment"
       android:id="@+id/face_view"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:layout_gravity="top" />
```
Use `AugmentedFaceFragment` in your `main_activity` layout

Implement interface in MainActivity

```
class MainActivity : AppCompatActivity(), AugmentedFaceListener {
   override fun onFaceAdded(face: AugmentedFaceNode) {}

   override fun onFaceUpdate(face: AugmentedFaceNode) {}
}
```
![1](https://github.com/selmancanklnc/T-AR_Makeup/assets/62688928/7cf406a8-45cd-4612-b689-69c037bcaed1)
![2](https://github.com/selmancanklnc/T-AR_Makeup/assets/62688928/288e6277-1cf2-40de-84a0-510efd60f45a)
